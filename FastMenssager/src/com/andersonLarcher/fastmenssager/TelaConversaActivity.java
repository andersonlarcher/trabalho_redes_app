package com.andersonLarcher.fastmenssager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class TelaConversaActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_conversa);
		
		String nome = getIntent().getStringExtra("nome");
		setTitle(nome);
		
//		TextView textView = (TextView) findViewById(R.id.textView1);
//		textView.setText(nome);
		
		List<TextView> listaDeMensagem = new ArrayList<>();
		ImageButton btEnviaMsg = (ImageButton) findViewById(R.id.imageButtonEnviar);
		btEnviaMsg.setOnClickListener(new View.OnClickListener() {
	        	
				
				public void onClick(View  v) {
					TextView textoMensagemEnviada = (TextView) findViewById(R.id.textViewMegEnviada);
					EditText textoPraEnviar = (EditText) findViewById(R.id.editTextMensagemEnviar);
					textoMensagemEnviada.setText(textoPraEnviar.getText());
					textoPraEnviar.setText("");
				}
			});
		
		
	}

}
