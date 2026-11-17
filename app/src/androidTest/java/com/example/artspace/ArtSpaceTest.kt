package com.example.artspace

import androidx.compose.ui.test.assertExists
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

class ArtSpaceTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun next_button_shows_second_artwork() {
        rule.setContent { ArtSpaceTheme { ArtSpaceApp() } }

        rule.onNodeWithText(artworks[0].title).assertExists()
        rule.onNodeWithText("Next").performClick()
        rule.onNodeWithText(artworks[1].title).assertExists()
    }

    @Test
    fun previous_button_wraps_to_last_artwork() {
        rule.setContent { ArtSpaceTheme { ArtSpaceApp() } }

        rule.onNodeWithText("Previous").performClick()
        rule.onNodeWithText(artworks.last().title).assertExists()
    }
}