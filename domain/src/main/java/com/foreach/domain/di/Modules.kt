package com.foreach.domain.di

import com.foreach.domain.interactor.SettingsInteractor
import com.foreach.domain.usecase.SettingsUseCase
import org.koin.dsl.module

val interactorModule = module {
    single<SettingsInteractor>{SettingsUseCase(get())}
}
