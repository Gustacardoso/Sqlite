package empresasconsultoria.gcsapps.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabelas
            bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR , idade INT(3))");

            //INSERIR DADOS
            bancodedados.execSQL("INSERT INTO pessoas (nome,idade)VALUES ('gustavo', 25)");
            bancodedados.execSQL("INSERT INTO pessoas (nome,idade)VALUES ('tamires', 24)");

            Cursor cursor = bancodedados.rawQuery("SELECT nome ,idade FROM pessoas", null);//metodo que recupar as pessoas dessa tabela

            //UPDATE
            //bancodedados.execSQL("UPDATE pessoas SET nome = 'gustimba' WHERE nome = 'gustavo'");
            // esta atualizando  na tabela pessoas, no nome gustimba aonde estava gustavo

            //DELETE
            //bancodedados.execSQL("DELETE FROM pessaos where nome = 'tamires'");
            // deletando  da tabela pessoas aonde o nome for tamires.

            //DELETANDO  A TABELA
            //bancodedados.execSQL("DROP TABLE pessoas");
               // delentando  toda a tabela pessoa

            //indice de cada coluna
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();// voltando o cursor para o começo
            while (cursor != null) {//utilizando  um while enquanto cursor for diferente de  null fizemos isso
                Log.i("Resultado = nome", cursor.getString(indiceColunaNome));
                Log.i("Resultado = idade ", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}