package ar.edu.unlp.jornadasead;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {

    TextView welcome, salida;
    Button btnEntrar, btnSalir;
    EditText inpNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        welcome = (TextView)findViewById(R.id.msjInicial);
        inpNombre = (EditText)findViewById(R.id.inpNombre);
        salida = (TextView)findViewById(R.id.msjSalida);
        btnSalir = (Button)findViewById(R.id.btnSalir);

        btnEntrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        btnEntrar.setOnLongClickListener(this);
        btnSalir.setOnLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String tmp = inpNombre.getText().toString();
        if (!tmp.isEmpty()){
            switch(v.getId()) {
                case R.id.btnEntrar:
                    salida.setText("Hola " + tmp);
                    break;
                case R.id.btnSalir:
                    salida.setText("Chau " + tmp);
                    break;
            }
        } else
            salida.setText("Ingrese su nombre...");
    }

    @Override
    public boolean onLongClick(View v) {
        String tmp = inpNombre.getText().toString();
        salida.setText("Solta " + tmp);

        return false;
    }
}
