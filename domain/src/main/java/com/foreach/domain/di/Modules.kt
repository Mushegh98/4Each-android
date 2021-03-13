package com.foreach.domain.di

import com.foreach.domain.interactor.SettingsInteractor
import com.foreach.domain.interactor.StartFragmentInteractor
import com.foreach.domain.interactor.ThemesInteractor
import com.foreach.domain.usecase.SettingsUseCase
import com.foreach.domain.usecase.StartFragmentUseCase
import com.foreach.domain.usecase.ThemesUseCase
import org.koin.dsl.module

val interactorModule = module {
    single<SettingsInteractor>{SettingsUseCase(get())}
    single<ThemesInteractor>{ThemesUseCase(get())}
    single<StartFragmentInteractor>{StartFragmentUseCase(get())}
}
