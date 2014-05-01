package com.andersonLarcher.fastmenssager;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.andersonLarcher.objetos.ItemListView;

public class HomeActivity extends ActionBarActivity {

	private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_home);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(new OnItemClickListener() {
        	
        	@Override
        	public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
        		ItemListView itemListView = (ItemListView) adapterView.getAdapter().getItem(position);
        		Intent intent = new Intent(HomeActivity.this, TelaConversaActivity.class);
        		intent.putExtra("nome", itemListView.getTexto());
        		startActivity(intent);
        	}
        });
        createListView();
        
    }

    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Mario do Armario", R.drawable.biff);
        ItemListView item2 = new ItemListView("João das Couves", R.drawable.volgarini);
        ItemListView item3 = new ItemListView("Zé Ruela", R.drawable.ricoldi);
        ItemListView item4 = new ItemListView("Xispirito", R.drawable.panngo);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens); 

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista e selecionada para rolagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
    
   
}

