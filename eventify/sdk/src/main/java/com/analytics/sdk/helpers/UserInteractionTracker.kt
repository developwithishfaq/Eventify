package com.analytics.sdk.helpers

import android.util.Log
import android.view.ActionMode
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.SearchEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent

internal class UserInteractionTracker(private val originalCallback: Window.Callback) :
    Window.Callback {

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> log("User touched at (${event.x}, ${event.y})")
            MotionEvent.ACTION_MOVE -> log("User moved at (${event.x}, ${event.y})")
            MotionEvent.ACTION_UP -> log("User lifted finger at (${event.x}, ${event.y})")
        }
        return originalCallback.dispatchTouchEvent(event)
    }

    private fun log(message: String) {
        Log.d("cvv", "UserInteractionTracker $message")
    }

    // Delegate all other methods to the original callback
    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean =
        originalCallback.onCreatePanelMenu(featureId, menu)

    override fun onPreparePanel(featureId: Int, view: View?, menu: Menu): Boolean {
        return originalCallback.onPreparePanel(featureId, view, menu)
    }

    override fun onWindowAttributesChanged(attrs: WindowManager.LayoutParams) =
        originalCallback.onWindowAttributesChanged(attrs)

    override fun onContentChanged() {
        originalCallback.onContentChanged()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) =
        originalCallback.onWindowFocusChanged(hasFocus)

    override fun onAttachedToWindow() {
        originalCallback.onAttachedToWindow()
    }

    override fun onPanelClosed(featureId: Int, menu: Menu) =
        originalCallback.onPanelClosed(featureId, menu)

    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean =
        originalCallback.onMenuOpened(featureId, menu)

    override fun onMenuItemSelected(featureId: Int, item: MenuItem): Boolean =
        originalCallback.onMenuItemSelected(featureId, item)

    override fun onDetachedFromWindow() = originalCallback.onDetachedFromWindow()
    override fun dispatchKeyEvent(event: KeyEvent): Boolean =
        originalCallback.dispatchKeyEvent(event)

    override fun dispatchKeyShortcutEvent(event: KeyEvent): Boolean =
        originalCallback.dispatchKeyShortcutEvent(event)

    override fun dispatchTrackballEvent(event: MotionEvent): Boolean =
        originalCallback.dispatchTrackballEvent(event)

    override fun dispatchGenericMotionEvent(event: MotionEvent): Boolean =
        originalCallback.dispatchGenericMotionEvent(event)

    override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent): Boolean =
        originalCallback.dispatchPopulateAccessibilityEvent(event)

    override fun onCreatePanelView(featureId: Int): View? =
        originalCallback.onCreatePanelView(featureId)

    override fun onSearchRequested(): Boolean = originalCallback.onSearchRequested()
    override fun onSearchRequested(searchEvent: SearchEvent): Boolean =
        originalCallback.onSearchRequested(searchEvent)

    override fun onWindowStartingActionMode(callback: ActionMode.Callback): ActionMode? =
        originalCallback.onWindowStartingActionMode(callback)

    override fun onWindowStartingActionMode(callback: ActionMode.Callback, type: Int): ActionMode? =
        originalCallback.onWindowStartingActionMode(callback, type)

    override fun onActionModeStarted(mode: ActionMode) = originalCallback.onActionModeStarted(mode)
    override fun onActionModeFinished(mode: ActionMode) =
        originalCallback.onActionModeFinished(mode)
}
