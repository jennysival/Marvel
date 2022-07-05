package br.com.zup.marvel.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.zup.marvel.data.datasource.local.dao.PersonagemDAO
import br.com.zup.marvel.domain.model.PersonagemModel
import kotlinx.coroutines.internal.synchronized

@Database(entities = [PersonagemModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class PersonagemDataBase: RoomDatabase() {
    abstract fun personagemDao(): PersonagemDAO


    //TODO: Não entendi o que esse companion faz. É padrão pra todos os projetos?
    companion object{
        @Volatile
        private var INSTANCE: PersonagemDataBase? = null

        fun getDatabase(context: Context): PersonagemDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonagemDataBase::class.java,
                    "personagem_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}