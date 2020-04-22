package com.quipper.android.apollofrontpage.di

import com.apollographql.apollo.ApolloClient
import com.quipper.android.apollofrontpage.repository.PostsRepository
import com.quipper.android.apollofrontpage.repository.impl.PostsRepositoryImpl
import com.quipper.android.apollofrontpage.PostListViewModel
import com.quipper.android.apollofrontpage.util.ApolloRxHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {
    single { ApolloClient.builder().serverUrl("http://10.0.2.2:8080/graphql").build() }
}

val repositoryModule = module {
    single { ApolloRxHelper() }
    factory<PostsRepository> { PostsRepositoryImpl(get(), get()) }
}

val viewModelModule = module {
    viewModel {
        PostListViewModel(
            postsRepository = get()
        )
    }
}