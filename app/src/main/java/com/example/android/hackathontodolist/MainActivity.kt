package com.example.android.hackathontodolist


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.raizlabs.android.dbflow.sql.language.Select
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar);

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ListAdaptor(this)
        fab.setOnClickListener { view ->
            startActivity(Intent(baseContext, AddItemActivity::class.java));

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (FirebaseAuth.getInstance().currentUser == null)
            MenuInflater(this).inflate(R.menu.menu, menu);
        return true;

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.login) {
            startActivity(Intent(baseContext,LoginActivity::class.java));
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        (recycler.adapter as ListAdaptor)
        var adapter = recycler.adapter as ListAdaptor;

        var items = Select()
                .from(ToDoListItem::class.java)
                .where()
                .queryList()
        adapter.addData(items);
    }

    public override fun onDestroy() {
        super.onDestroy()
    }
}
