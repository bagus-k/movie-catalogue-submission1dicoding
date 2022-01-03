package com.bagus.moviecatalogue.ui.home


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.bagus.moviecatalogue.R
import com.bagus.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvshow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(withText("${dummyMovie[0].releaseDate}")))
        onView(withId(R.id.text_desc_item)).check(matches(isDisplayed()))
        onView(withId(R.id.text_desc_item)).check(matches(withText("${dummyMovie[0].desc}")))
        onView(withId(R.id.genre_value)).check(matches(isDisplayed()))
        onView(withId(R.id.genre_value)).check(matches(withText("Movie")))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvshow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvshow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(withText("${dummyTvShow[0].releaseDate}")))
        onView(withId(R.id.text_desc_item)).check(matches(isDisplayed()))
        onView(withId(R.id.text_desc_item)).check(matches(withText("${dummyTvShow[0].desc}")))
        onView(withId(R.id.genre_value)).check(matches(isDisplayed()))
        onView(withId(R.id.genre_value)).check(matches(withText("TV Show")))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }
}