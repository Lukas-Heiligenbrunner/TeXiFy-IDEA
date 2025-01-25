package nl.hannahsten.texifyidea.inspections.latex.probablebugs.packages

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import nl.hannahsten.texifyidea.configureByFilesWithMockCache
import nl.hannahsten.texifyidea.testutils.writeCommand

class LatexPackageNameDoesNotMatchFileNameInspectionTest : BasePlatformTestCase() {

    override fun getTestDataPath(): String {
        return "test/resources/inspections/latex/packagenamedoesnotmatch"
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(
            LatexPackageNameDoesNotMatchFileNameInspection(),
            LatexPackageSubdirectoryInspection()
        )
    }

    fun testWarnings() {
        myFixture.configureByFile("mypackage_warnings.sty")
        myFixture.checkHighlighting()
    }

    fun testNoWarning() {
        myFixture.configureByFile("mypackge.sty")
        myFixture.checkHighlighting()
    }

    fun testQuickfix() {
        myFixture.configureByFile("mypackage.sty")
        val quickFixes = myFixture.getAllQuickFixes()
        assertEquals(1, quickFixes.size)
        writeCommand(myFixture.project) {
            quickFixes.first().invoke(myFixture.project, myFixture.editor, myFixture.file)
        }

        myFixture.checkResult(
            """
            \NeedsTeXFormat{LaTeX2e}
            \ProvidesPackage{mypackage}[My Package]
            """.trimIndent()
        )
    }

    fun testNoWarnings() {
        try {
            myFixture.configureByFilesWithMockCache("pkg/secondpackage.sty", "main.tex")
            myFixture.checkHighlighting()
        }
        finally {
            clearAllMocks()
            unmockkAll()
        }
    }

    fun testSubdirWarnings() {
        try {
            myFixture.configureByFilesWithMockCache("pkg/mypackage.sty", "main.tex")
            myFixture.checkHighlighting()
        }
        finally {
            clearAllMocks()
            unmockkAll()
        }
    }
}