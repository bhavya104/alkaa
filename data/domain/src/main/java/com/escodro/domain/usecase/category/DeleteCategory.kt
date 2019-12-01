package com.escodro.domain.usecase.category

import com.escodro.core.extension.applySchedulers
import com.escodro.domain.mapper.CategoryMapper
import com.escodro.domain.model.Category
import com.escodro.domain.repository.CategoryRepository
import com.escodro.domain.viewdata.ViewData
import com.escodro.local.provider.DaoProvider

/**
 * Use case to delete a category from the database.
 */
class DeleteCategory(
    private val categoryRepository: CategoryRepository,
    private val daoProvider: DaoProvider,
    private val mapper: CategoryMapper
) {

    /**
     * Deletes a category.
     *
     * @param category category to be deleted
     *
     * @return observable to be subscribe
     */
    operator fun invoke(category: ViewData.Category) =
        daoProvider.getCategoryDao()
            .deleteCategory(mapper.toEntityCategory(category))
            .applySchedulers()

    @Suppress("UndocumentedPublicFunction")
    fun test(category: Category) =
        categoryRepository.deleteCategory(category).applySchedulers()
}
