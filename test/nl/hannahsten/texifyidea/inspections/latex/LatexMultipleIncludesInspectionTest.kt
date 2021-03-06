package nl.hannahsten.texifyidea.inspections.latex

import nl.hannahsten.texifyidea.file.LatexFileType
import nl.hannahsten.texifyidea.inspections.TexifyInspectionTestBase

class LatexMultipleIncludesInspectionTest : TexifyInspectionTestBase(LatexMultipleIncludesInspection()) {
    fun testWarning() {
        myFixture.configureByText(
            LatexFileType,
            """
            \usepackage{<error descr="Package has already been included">rubikrotation</error>}
            \usepackage{<error descr="Package has already been included">rubikrotation</error>}
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testConditionalInclude() {
        myFixture.configureByText(
            LatexFileType,
            """
            \documentclass{article}
            
            \onlyifstandalone{
            \usepackage{amsmath}
            }
            \usepackage{amsmath}
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }
}