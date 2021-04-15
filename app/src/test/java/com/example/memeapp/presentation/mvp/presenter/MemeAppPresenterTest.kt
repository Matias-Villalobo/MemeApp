package com.example.memeapp.presentation.mvp.presenter

import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.mvp.contract.MemeAppContract
import com.example.memeapp.utils.MemesConstantsUtils.ID
import com.example.memeapp.utils.MemesConstantsUtils.ZERO_VALUE
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito.mock
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class MemeAppPresenterTest {
    private val memeAppModel = mock(MemeAppContract.MemeAppModel::class.java)
    private val view = mock(MemeAppContract.MemeAppView::class.java)
    private lateinit var memeAppPresenter: MemeAppContract.MemeAppPresenter
    private var memes: List<MemesEntity> = mock()

    @Before
    fun setUp() {
        memeAppPresenter = MemeAppPresenter(memeAppModel, view)
    }

    @Test
    fun `connection unsuccessful test`() {
        whenever(memeAppModel.getMemesData()).thenReturn(Observable.error(Throwable()))
        memeAppPresenter.fetchMemes()
        verify(view).showProgressBar(true)
        verify(view).showProgressBar(false)
        verify(view).showError()
    }

    @Test
    fun `connection successful test`() {
        whenever(memeAppModel.getMemesData()).thenReturn(Observable.just(memes))
        memeAppPresenter.fetchMemes()
        verify(view).showProgressBar(true)
        verify(memeAppModel).getMemesData()
        verify(view).showData(memes)
        verify(view).showProgressBar(false)
    }

    @Test
    fun `when a meme card is pressed, show details in a fragment`() {
        memeAppPresenter.onMemeClicked(ID)
        verify(view).showMemeInfo(ID)
    }

    @Test
    fun `load local database data`() {
        whenever(memeAppModel.loadMemesFromDatabase()).thenReturn((memes))
        memeAppPresenter.getMemesFromDatabase()
        verify(view).cleanRecycler()
        verify(view).showProgressBar(true)
        verify(memeAppModel).loadMemesFromDatabase()
        verify(view).showData(memes)
        verify(view).showProgressBar(false)
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {
                override fun scheduleDirect(
                    run: Runnable,
                    delay: Long,
                    unit: TimeUnit
                ): Disposable {
                    return super.scheduleDirect(run, ZERO_VALUE.toLong(), unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false, false)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            io.reactivex.rxjava3.android.plugins.RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }

}
