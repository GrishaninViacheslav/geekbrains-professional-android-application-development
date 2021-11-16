package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository

class DictionaryRepository(private val api: IDataSource) : IDictionaryRepository {
    override suspend fun getDefinitions(word: String) =
        api.getDefinitionsAsync(word).await()
}