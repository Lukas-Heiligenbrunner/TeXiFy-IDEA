package nl.hannahsten.texifyidea.action.evince

import nl.hannahsten.texifyidea.action.ForwardSearchActionBase
import nl.hannahsten.texifyidea.run.linuxpdfviewer.PdfViewer

/**
 * Starts a forward search action in Evince.
 *
 * Note: this is only available on Linux.
 *
 * @author Thomas Schouten
 */
open class ForwardSearchAction : ForwardSearchActionBase(PdfViewer.EVINCE)