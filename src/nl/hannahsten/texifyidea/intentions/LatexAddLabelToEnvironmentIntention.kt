package nl.hannahsten.texifyidea.intentions

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.refactoring.suggested.startOffset
import nl.hannahsten.texifyidea.psi.LatexCommands
import nl.hannahsten.texifyidea.psi.LatexEnvironment
import nl.hannahsten.texifyidea.psi.LatexPsiHelper
import nl.hannahsten.texifyidea.util.Magic
import nl.hannahsten.texifyidea.util.childrenOfType
import nl.hannahsten.texifyidea.util.endOffset
import nl.hannahsten.texifyidea.util.files.isLatexFile
import nl.hannahsten.texifyidea.util.formatAsLabel

open class LatexAddLabelToEnvironmentIntention(val environment: SmartPsiElementPointer<LatexEnvironment>? = null) :
    LatexAddLabelIntention() {

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        if (file?.isLatexFile() == false) {
            return false
        }

        return findTarget<LatexEnvironment>(editor, file)?.environmentName in Magic.Environment.labeled
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        if (editor == null || file == null) {
            return
        }

        val environment = this.environment?.element
            ?: findTarget(editor, file)
            ?: return

        val helper = LatexPsiHelper(project)
        // Determine label name.
        val prefix = Magic.Environment.labeled[environment.environmentName] ?: ""
        val createdLabel = getUniqueLabelName(
            environment.environmentName.formatAsLabel(),
            prefix, environment.containingFile
        )

        if (Magic.Environment.labelAsParameter.contains(environment.environmentName)) {
            val endMarker =
                editor.document.createRangeMarker(environment.startOffset, environment.endOffset())
            createLabelAndStartRename(editor, project, environment.beginCommand, createdLabel, endMarker)
        }
        else {
            // in a float environment the label must be inserted after a caption
            val labelCommand = helper.addToContent(
                environment, helper.createLabelCommand(createdLabel.labelText),
                environment.environmentContent?.childrenOfType<LatexCommands>()
                    ?.findLast { c -> c.name == "\\caption" }
            )

            // Adjust caret offset
            val caretModel = editor.caretModel
            caretModel.moveToOffset(labelCommand.endOffset())
        }

    }

}