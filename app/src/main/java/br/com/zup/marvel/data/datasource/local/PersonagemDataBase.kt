package br.com.zup.marvel.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.marvel.data.datasource.local.dao.PersonagemDAO
import br.com.zup.marvel.domain.model.PersonagemModel

@Database(entities = [PersonagemModel::class], version = 1)
abstract class PersonagemDataBase: RoomDatabase() {
    abstract fun personagemDao(): PersonagemDAO

    companion object{
        @Volatile
        private var INSTANCE: PersonagemDataBase? = null

        //o context do parametro abaixo vai ser a application no usecase
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