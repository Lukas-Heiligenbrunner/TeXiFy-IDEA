package nl.hannahsten.texifyidea.inspections.latex

import com.intellij.psi.PsiElement
import nl.hannahsten.texifyidea.inspections.TexifyRegexInspection
import nl.hannahsten.texifyidea.psi.LatexCommands
import nl.hannahsten.texifyidea.util.firstParentOfType
import nl.hannahsten.texifyidea.util.isCommandDefinition
import java.util.regex.Pattern

class LatexEscapeHashOutsideCommandInspection : TexifyRegexInspection(
        inspectionDisplayName = "Escape hash symbol outside of command definition",
        inspectionId = "EscapeHashOutsideCommand",
        pattern = Pattern.compile("""(?<!\\)#"""),
        errorMessage = { "# should be escaped" },
        quickFixName = { "escape #" },
        replacement = { _, _ -> """\#""" }
) {
    override fun checkContext(element: PsiElement): Boolean {
        return !element.firstParentOfType(LatexCommands::class).isCommandDefinition()
    }
}