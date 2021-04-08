package com.example.memeapp.presentation.mvp.presenter


import com.example.memeapp.domain.entity.MemesEntity
import com.example.memeapp.presentation.mvp.model.MemeDetailModel
import com.example.memeapp.presentation.mvp.view.MemeDetailView
import com.example.memeapp.utils.CharactersConstantsUtils.ID
import com.example.memeapp.utils.CharactersConstantsUtils.ZERO_VALUE
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
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

class MemeDetailPresenterTest {
    private val view: MemeDetailView = mock()
    private val model: MemeDetailModel = mock()
    private lateinit var presenter: MemeDetailPresenter
    private var characters: MemesEntity = mock()

    @Before
    fun setUp() {
        presenter = MemeDetailPresenter(model, view)
    }

    @Test
    fun `when an item is pressed, retrieve info`() {
        whenever(model.getDataSingleMeme(ID)).thenReturn(Observable.just(characters))
        presenter.retrieveSingleMemeInfo(ID)
        verify(view).showProgressBar(true)
        verify(model).getDataSingleMeme(ID)
        verify(view).showFragmentData(characters)
    }

    @Test
    fun `when an item is pressed, do not retrieve info`() {
        whenever(model.getDataSingleMeme(ID)).thenReturn(Observable.error(Throwable()))
        presenter.retrieveSingleMemeInfo(ID)
        verify(view).showProgressBar(true)
        verify(model).getDataSingleMeme(ID)
        verify(view).showFragmentError()
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
