package nl.hannahsten.texifyidea.completion

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.Test

class LatexPathCompletionTest : BasePlatformTestCase() {
    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()
    }

    @Test
    fun testCompleteRelativePath(){
        myFixture.configureByText("main.tex","""\input{<caret>}""")
        myFixture.configureByText("main2.tex","""bla txt ext""")

        val result = myFixture.complete(CompletionType.BASIC)

        assert(result.size > 0)
    }
}