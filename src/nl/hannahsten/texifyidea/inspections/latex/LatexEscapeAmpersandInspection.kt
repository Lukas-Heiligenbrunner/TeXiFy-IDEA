package nl.hannahsten.texifyidea.inspections.latex

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiElement
import nl.hannahsten.texifyidea.inspections.TexifyRegexInspection
import nl.hannahsten.texifyidea.psi.LatexEnvironment
import nl.hannahsten.texifyidea.util.Magic
import nl.hannahsten.texifyidea.util.firstParentOfType
import nl.hannahsten.texifyidea.util.inMathContext
import nl.hannahsten.texifyidea.util.isComment
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * @author Johannes Berger
 */
class LatexEscapeAmpersandInspection : TexifyRegexInspection(
        inspectionDisplayName = "Unescaped & character",
        inspectionId = "LatexEscapeAmpersand",
        errorMessage = { "Escape character \\ expected" },
        highlight = ProblemHighlightType.WARNING,
        pattern = Pattern.compile("""(?<!\\)&"""),
        replacement = { _, _ -> """\&""" },
        quickFixName = { """Change to \&""" }
) {
    override fun checkContext(matcher: Matcher, element: PsiElement): Boolean {
        if (element.isComment() || element.inMathContext() || element.isInTableEnvironment()) {
            return false
        }

        return checkContext(element)
    }

    private fun PsiElement.isInTableEnvironment(): Boolean {
        return this.firstParentOfType(LatexEnvironment::class)?.environmentName in Magic.Environment.tableEnvironments
    }
}