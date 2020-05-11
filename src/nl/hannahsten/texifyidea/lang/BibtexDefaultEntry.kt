package nl.hannahsten.texifyidea.lang

import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ADDENDUM
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ADDRESS
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.AFTERWORD
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ANNOTATOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.AUTHOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.BOOKAUTHOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.BOOKSUBTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.BOOKTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.BOOKTITLEADDON
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.CHAPTER
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.COMMENTATOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.DATE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.DOI
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EDITION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EDITOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EDITORA
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EDITORB
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EDITORC
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EID
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EPRINT
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EPRINTCLASS
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EPRINTTYPE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EVENTDATE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EVENTTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.EVENTTITLEADDON
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.FOREWORD
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.HOLDER
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.HOWPUBLISHED
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.INSTITUTION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.INTRODUCTION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISBN
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISRN
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISSN
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISSUE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISSUESUBTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ISSUETITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.JOURNAL
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.JOURNALSUBTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.JOURNALTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.KEY
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.LANGUAGE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.LOCATION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.MAINSUBTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.MAINTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.MAINTITLEADDON
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.MONTH
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.NOTE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.NUMBER
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ORGANISATION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.ORIGLANGUAGE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.PAGES
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.PAGETOTAL
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.PART
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.PUBLISHER
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.PUBSTATE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.SCHOOL
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.SERIES
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.SUBTITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.TITLE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.TITLEADDON
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.TRANSLATOR
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.TYPE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.URL
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.URLDATE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.VENUE
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.VERSION
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.VOLUME
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.VOLUMES
import nl.hannahsten.texifyidea.lang.BibtexDefaultEntryType.YEAR
import nl.hannahsten.texifyidea.lang.Package.Companion.BIBLATEX

/**
 * @author Hannah Schellekens
 */
enum class BibtexDefaultEntry(
        override val token: String,
        override val description: String,
        override val required: Array<BibtexEntryField>,
        override val optional: Array<BibtexEntryField>,
        override val dependency: Package = Package.DEFAULT
) : BibtexEntryType {

    // Regular entry types.
    ARTICLE("article",
            "An article from a journal or magazine.",
            arrayOf(AUTHOR, TITLE, JOURNAL, YEAR),
            arrayOf(NUMBER, PAGES, MONTH, NOTE, VOLUME, KEY)
    ),
    BOOK("book",
            "A book with an explicit publisher.",
            arrayOf(AUTHOR, TITLE, PUBLISHER, YEAR),
            arrayOf(EDITION, VOLUME, NUMBER, SERIES, ADDRESS, EDITION, MONTH, NOTE, KEY)
    ),
    BOOKLET("booklet",
            "A work that is printed and bound, but without a named publisher or sponsoring institution.",
            arrayOf(TITLE),
            arrayOf(AUTHOR, HOWPUBLISHED, ADDRESS, MONTH, YEAR, NOTE, KEY)
    ),
    CONFERENCE("conference",
            "The same as inproceedings, included for Scribe compatibility.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, YEAR),
            arrayOf(EDITOR, VOLUME, NUMBER, SERIES, PAGES, ADDRESS, MONTH, ORGANISATION, PUBLISHER, NOTE, KEY)
    ),
    INBOOK("inbook",
            "A part of a book, usually untitled. May be a chapter (or section, etc.) and/or a range of pages.",
            arrayOf(AUTHOR, TITLE, PAGES, PUBLISHER, YEAR),
            arrayOf(EDITOR, CHAPTER, VOLUME, NUMBER, SERIES, TYPE, ADDRESS, EDITION, MONTH, NOTE, KEY)
    ),
    INCOLLECTION("incollection",
            "A part of a book having its own title.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, PUBLISHER, YEAR),
            arrayOf(EDITOR, VOLUME, NUMBER, SERIES, TYPE, CHAPTER, PAGES, ADDRESS, EDITION, MONTH, NOTE, KEY)
    ),
    INPROCEEDINGS("inproceedings",
            "An article in a conference proceedings.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, YEAR),
            arrayOf(EDITOR, VOLUME, NUMBER, SERIES, PAGES, ADDRESS, MONTH, ORGANISATION, PUBLISHER, NOTE, KEY)
    ),
    MANUAL("manual",
            "Technical documentation.",
            arrayOf(TITLE),
            arrayOf(AUTHOR, ORGANISATION, ADDRESS, EDITION, MONTH, YEAR, NOTE, KEY)
    ),
    MASTERTHESIS("masterthesis",
            "A Master's thesis.",
            arrayOf(AUTHOR, TITLE, SCHOOL, YEAR),
            arrayOf(TYPE, ADDRESS, MONTH, NOTE, KEY)
    ),
    MISC("misc",
            "For use when nothing else fits.",
            emptyArray(),
            arrayOf(AUTHOR, TITLE, HOWPUBLISHED, MONTH, YEAR, NOTE, KEY)
    ),
    PHDTHESIS("phdthesis",
            "A Ph.D. thesis.",
            arrayOf(AUTHOR, TITLE, SCHOOL, YEAR),
            arrayOf(TYPE, ADDRESS, MONTH, NOTE, KEY)
    ),
    PROCEEDINGS("proceedings",
            "The proceedings of a conference.",
            arrayOf(TITLE, YEAR),
            arrayOf(EDITOR, VOLUME, NUMBER, SERIES, ADDRESS, MONTH, PUBLISHER, ORGANISATION, NOTE, KEY)
    ),
    TECHREPORT("techreport",
            "A report published by a school or other institution, usually numbered within a series.",
            arrayOf(AUTHOR, TITLE, INSTITUTION, YEAR),
            arrayOf(TYPE, NUMBER, ADDRESS, MONTH, NOTE, KEY)
    ),
    UNPUBLISHED("unpublished",
            "A document having an author and title, but not formally published.",
            arrayOf(AUTHOR, TITLE, NOTE),
            arrayOf(MONTH, YEAR, KEY)
    ),

    // Special entries
    STRING("string",
            "Define a string to be used later on in the bibliography",
            emptyArray(),
            emptyArray()
    ),
    PREAMBLE("preamble",
            "You can define some LaTeX commands that will be included in the .bbl file generated by BibTex using the preamble",
            emptyArray(),
            emptyArray()
    ),

    // BibLaTeX entries
    BIBLATEX_ARTICLE("article",
            "An article in a journal, magazine, newspaper, or other periodical which forms a self-contained unit with its own title.",
            arrayOf(AUTHOR, TITLE, JOURNALTITLE, DATE),
            arrayOf(TRANSLATOR, ANNOTATOR, COMMENTATOR, SUBTITLE, TITLEADDON, EDITOR, EDITORA, EDITORB, EDITORC, JOURNALSUBTITLE, ISSUETITLE, ISSUESUBTITLE, LANGUAGE, ORIGLANGUAGE, SERIES, VOLUME, NUMBER, EID, ISSUE, MONTH, PAGES, VERSION, NOTE, ISSN, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_BOOK("book",
            "A single-volume book with one or more authors where the authors share credit for the work as a whole.",
            arrayOf(AUTHOR, TITLE, DATE),
            arrayOf(EDITOR, EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, LANGUAGE, ORIGLANGUAGE, VOLUME, PART, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    MVBOOK("mvbook",
            "A multi-volume @book.",
            arrayOf(AUTHOR, TITLE, DATE),
            arrayOf(EDITOR, EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, LANGUAGE, ORIGLANGUAGE, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_INBOOK("inbook",
            "A part of a book which forms a self-contained unit with its own title.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, DATE),
            arrayOf(BOOKAUTHOR, EDITOR, EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, BOOKSUBTITLE, BOOKTITLEADDON, LANGUAGE, ORIGLANGUAGE, VOLUME, PART, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, CHAPTER, PAGES, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_BOOKLET("booklet",
            "A book-like work without a format publisher or sponsoring insitution.",
            arrayOf(AUTHOR, TITLE, DATE),
            arrayOf(EDITOR, SUBTITLE, TITLEADDON, LANGUAGE, HOWPUBLISHED, TYPE, NOTE, LOCATION, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    COLLECTION("collection",
            "A single-volume collection with multiple, self-contained contributions by distinct authors which have their own title.",
            arrayOf(EDITOR, TITLE, DATE),
            arrayOf(EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, LANGUAGE, ORIGLANGUAGE, VOLUME, PART, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    MVCOLLECTION("mvcollection",
            "A multi-volume @collection.",
            arrayOf(EDITOR, TITLE, DATE),
            arrayOf(YEAR, EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, LANGUAGE, ORIGLANGUAGE, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_INCOLLECTION("incollection",
            "A contribution to a collection which forms a self-contained unit with a distinct author and title.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, DATE),
            arrayOf(YEAR, EDITOR, EDITORA, EDITORB, EDITORC, TRANSLATOR, ANNOTATOR, COMMENTATOR, INTRODUCTION, FOREWORD, AFTERWORD, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, BOOKSUBTITLE, BOOKTITLEADDON, LANGUAGE, ORIGLANGUAGE, VOLUME, PART, EDITION, VOLUMES, SERIES, NUMBER, NOTE, PUBLISHER, LOCATION, ISBN, CHAPTER, PAGES, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    DATASET("dataset",
            "A data set or a similar collection of (mostly) raw data.",
            arrayOf(AUTHOR, TITLE, DATE),
            arrayOf(YEAR, SUBTITLE, TITLEADDON, LANGUAGE, EDITION, TYPE, SERIES, NUMBER, VERSION, NOTE, ORGANISATION, PUBLISHER, LOCATION, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_MANUAL("manual",
            "Technical or other documentation.",
            arrayOf(TITLE, DATE),
            arrayOf(AUTHOR, EDITOR, YEAR, SUBTITLE, TITLEADDON, LANGUAGE, EDITION, TYPE, SERIES, NUMBER, VERSION, NOTE, ORGANISATION, PUBLISHER, LOCATION, ISBN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    ONLINE("online",
            "A website.",
            arrayOf(AUTHOR, TITLE, DATE, URL),
            arrayOf(SUBTITLE, TITLEADDON, LANGUAGE, VERSION, NOTE, ORGANISATION, ADDENDUM, PUBSTATE, EPRINTCLASS, EPRINTTYPE, URLDATE),
            BIBLATEX
    ),
    PATENT("patent",
            "A patent or patent request.",
            arrayOf(AUTHOR, TITLE, NUMBER, DATE),
            arrayOf(YEAR, HOLDER, SUBTITLE, TITLEADDON, TYPE, VERSION, LOCATION, NOTE, MONTH, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    PERIODICAL("periodical",
            "A complete issue of a periodical.",
            arrayOf(EDITOR, TITLE, DATE),
            arrayOf(YEAR, EDITORA, EDITORB, EDITORC, SUBTITLE, ISSUETITLE, ISSUESUBTITLE, LANGUAGE, SERIES, VOLUME, NUMBER, ISSUE, MONTH, NOTE, ISSN, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_PROCEEDINGS("proceedings",
            "A single-volume conference proceedings.",
            arrayOf(TITLE, DATE),
            arrayOf(YEAR, EDITOR, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, EVENTTITLE, EVENTTITLEADDON, EVENTDATE, VENUE, LANGUAGE, VOLUME, PART, VOLUMES, SERIES, NUMBER, NOTE, ORGANISATION, PUBLISHER, LOCATION, MONTH, ISBN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    MVPROCEEDINGS("mvproceedings",
            "A multi-volume @proceedings entry.",
            arrayOf(TITLE, DATE),
            arrayOf(YEAR, EDITOR, SUBTITLE, TITLEADDON, EVENTTITLE, EVENTTITLEADDON, EVENTDATE, VENUE, LANGUAGE, VOLUMES, SERIES, NUMBER, NOTE, ORGANISATION, PUBLISHER, LOCATION, MONTH, ISBN, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_INPROCEEDINGS("inproceedings",
            "An article in a conference proceedings.",
            arrayOf(AUTHOR, TITLE, BOOKTITLE, DATE),
            arrayOf(EDITOR, SUBTITLE, TITLEADDON, MAINTITLE, MAINSUBTITLE, MAINTITLEADDON, BOOKSUBTITLE, BOOKTITLEADDON, EVENTTITLE, EVENTTITLEADDON, EVENTDATE, VENUE, LANGUAGE, VOLUME, PART, VOLUMES, SERIES, NUMBER, NOTE, ORGANISATION, PUBLISHER, LOCATION, MONTH, ISBN, CHAPTER, PAGES, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    REPORT("report",
            "A technical report, research report, or white paper published by a university or other institution.",
            arrayOf(AUTHOR, TITLE, TYPE, INSTITUTION, DATE),
            arrayOf(YEAR, SUBTITLE, TITLEADDON, LANGUAGE, NUMBER, VERSION, NOTE, LOCATION, MONTH, ISRN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_THESIS("thesis",
            "A thesis written for an educational institution to satisfy the requirements for a degree.",
            arrayOf(AUTHOR, TITLE, TYPE, INSTITUTION, DATE),
            arrayOf(YEAR, SUBTITLE, TITLEADDON, LANGUAGE, NOTE, LOCATION, MONTH, ISBN, CHAPTER, PAGES, PAGETOTAL, ADDENDUM, PUBSTATE, DOI, EPRINT, EPRINTCLASS, EPRINTTYPE, URL, URLDATE),
            BIBLATEX
    ),
    BIBLATEX_UNPUBLISHED("unpublished",
            "A work with an author and a title which has not been formally published.",
            arrayOf(AUTHOR, TITLE, DATE),
            arrayOf(SUBTITLE, TITLEADDON, TYPE, EVENTTITLE, EVENTTITLEADDON, EVENTDATE, VENUE, LANGUAGE, HOWPUBLISHED, NOTE, LOCATION, ISBN, MONTH, ADDENDUM, PUBSTATE, URL, URLDATE),
            BIBLATEX
    );

    companion object {

        private val lookup: MutableMap<String, BibtexEntryType> = HashMap()

        init {
            for (entry in values()) {
                lookup[entry.token] = entry
            }
        }

        @JvmStatic
        operator fun get(token: String): BibtexEntryType? {
            var trimmedToken = token.toLowerCase()
            if (token.startsWith("@")) {
                trimmedToken = token.substring(1)
            }
            return lookup[trimmedToken]
        }
    }
}