package com.example.kapil.recyclerview;

//import android.support.annotation.IdRes;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.RadioGroup;
//import android.widget.Spinner;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.Spinner;
//import android.widget.SpinnerAdapter;
//import android.widget.Toast;
//
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    // ListView listView;
//
//    private RecyclerView recyclerView;
//
//    AppUtility appUtility;
//
//    // ArrayAdapter<String> namesAdapter;
//    // ListAdapterPeople listAdapterPeople;
//
//    ListAdapterWithRecycleView listAdapterWithRecycleView;
//
//    private EditText editTextFirstName, editTextLastName;
//    private Spinner spinnerNationality;
//    private RadioGroup radioGroup;
//    private Button buttonAdd;
//
//    List<Person> people;
//    int modificationIndex = -1;
//
//    String firstName, lastName, nationality;
//    Person.GENDER gender;
//
//    LinearLayoutManager linearLayoutManager;
//
//
//    GridLayoutManager gridLayoutManager;
//    StaggeredGridLayoutManager staggeredGridLayoutManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        recyclerView =(RecyclerView) findViewById(R.id.recycleListView);
////        appUtility=AppUtility.getAppUtility(getApplicationContext());
////
////       // namesAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,appUtility.getNames());
////       // listAdapterPeople = new ListAdapterPeople(this,appUtility.getPeople());
////        listAdapterWithRecycleView= new ListAdapterWithRecycleView(this,appUtility.getPeople());
////
//////        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//////        gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//////        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//////            @Override
//////            public int getSpanSize(int position) {
//////                return (position%3==0?2:1);
//////            }
//////        });
//////
//////        staggeredGridLayoutManager = new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL);
//////
////
////
////
////
////
////
////        linearLayoutManager = new LinearLayoutManager(this);
////        recyclerView.setLayoutManager(linearLayoutManager);
////        recyclerView.setAdapter(listAdapterWithRecycleView);
////
////      //  listView.setAdapter(listAdapterPeople);
//
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        appUtility = AppUtility.getAppUtility(getApplicationContext());
//        initPersonInputForm();
//        recyclerView = (RecyclerView) findViewById(R.id.recycleListView);
//
//        people = appUtility.getPeople();
//
//        listAdapterWithRecycleView = new ListAdapterWithRecycleView(this, people);
//        listAdapterWithRecycleView.setPersonModifier((ListAdapterWithRecycleView.PersonModifier) this);
//
//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
//
//        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
//
//        linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(listAdapterWithRecycleView);
//
//
//    }
//
//
//    private void initPersonInputForm() {
//        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
//        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
//        radioGroup = (RadioGroup) findViewById(R.id.radioGroupGender);
//
//        spinnerNationality = (Spinner) findViewById(R.id.spinnerNationality);
//        spinnerNationality.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appUtility.getUniqueNationalitiesArray()));
//        buttonAdd = (Button) findViewById(R.id.buttonAdd);
//        buttonAdd.setTag("Add");
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                switch (i) {
//                    case R.id.radioButtonMale:
//                        gender = Person.GENDER.MALE;
//                        break;
//                    case R.id.radioButtonFemale:
//                        gender = Person.GENDER.FEMALE;
//                        break;
//                    default:
//                        gender = null;
//                }
//            }
//        });
//
//        spinnerNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                nationality = getResources().getStringArray(R.array.nationalities)[i];
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        buttonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firstName = editTextFirstName.getText().toString();
//                lastName = editTextLastName.getText().toString();
//                Person person = null;
//
//                if (isInputDataValid()) {
//                    person = new Person(firstName, lastName, gender, nationality);
//                } else {
//                    Toast.makeText(MainActivity.this, "Input Invalid", Toast.LENGTH_LONG).show();
//                }
//
//                String behaviour = (String) buttonAdd.getTag();
//                if (behaviour.equalsIgnoreCase("Add")) {
//                    if (person != null) {
//                        people.add(person);
//                        listAdapterWithRecycleView.notifyDataSetChanged();
//                        recyclerView.scrollToPosition(people.size() - 1);
//                        clearInputForm();
//                    }
//                } else if (behaviour.equalsIgnoreCase("modify")) {
//                    if (person != null) {
//                        try {
//                            people.get(modificationIndex).setName(person.getName());
//                            people.get(modificationIndex).setLastname(person.getLastname());
//                            people.get(modificationIndex).setGender(person.getGender());
//                            people.get(modificationIndex).setNationality((String) spinnerNationality.getSelectedItem());
//
//                            listAdapterWithRecycleView.notifyItemChanged(modificationIndex);
//                            clearInputForm();
//                            buttonAdd.setTag("Add");
//                            buttonAdd.setText("Add");
//                        } catch (IndexOutOfBoundsException exception) {
//                            Toast.makeText(MainActivity.this, "Can't modify, item moved", Toast.LENGTH_LONG).show();
//                            listAdapterWithRecycleView.notifyDataSetChanged();
//                            clearInputForm();
//                            buttonAdd.setTag("Add");
//                            buttonAdd.setText("Add");
//                        }
//                    }
//                }
//
//            }
//        });
//    }
//
//    private boolean isInputDataValid() {
//        if (AppUtility.isStringEmpty(firstName) || AppUtility.isStringEmpty(lastName) || AppUtility.isStringEmpty(nationality) || gender == null) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    private void clearInputForm() {
//        editTextFirstName.setText("");
//        editTextLastName.setText("");
//        radioGroup.clearCheck();
//        spinnerNationality.setSelection(0);
//    }
//
//
//    @Override
//    public void onPersonSelected(int position) {
//        modificationIndex = position;
//        Person person = people.get(position);
//        buttonAdd.setTag("Modify");
//        buttonAdd.setText("Modify");
//
//        editTextFirstName.setText(person.getName());
//        editTextLastName.setText(person.getLastname());
//        if (person.getGender() == Person.GENDER.MALE) {
//            ((RadioButton) findViewById(R.id.radioButtonMale)).performClick();
//        } else if (person.getGender() == Person.GENDER.FEMALE) {
//            ((RadioButton) findViewById(R.id.radioButtonFemale)).performClick();
//        }
//        spinnerNationality.setSelection(appUtility.getNationalityForSelectedIndex(person.getNationality()));
//    }
//
//    @Override
//    public void onPersonDeleted(int position) {
//        buttonAdd.setTag("Add");
//        buttonAdd.setText("Add");
//        clearInputForm();
//    }
//
//
//
//}


// we further dissect the usage of notifyDatasetChanged method of RecyclerView.Adapter. Through a demo we realize that notifyDatasetChanged forces the invocation of both onCreateViewHolder and onBindViewHolder. Invoking onCreateViewHolder even when the size of the data set has not changed doesn't make sense at all. That is when we start using another method of RecyclerView.Adapter - notifyItemChanged(position) which offers much better option than notifyDatasetChanged.

// Now the concept of supporting heterogenous row items in RecyclerView. We start by creating another View holder inside RecyclerView. Adapter implementation. We need to make use of a more generic RecyclerView.ViewHolder to support more than one ViewHolder in adapter. We will have to override more another method in RecylerView.Adapter called - getItemViewType which returns what kind of view needs to be rendered in RecyclerView.

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListAdapterWithRecycleView.PersonModifier{

    private RecyclerView recyclerView;
    AppUtility appUtility;

    ListAdapterWithRecycleView listAdapterWithRecycleView;

    private EditText editTextFirstName, editTextLastName;
    private Spinner spinnerNationality;
    private RadioGroup radioGroup;
    private Button buttonAdd;

    List<Person> people;
    List<Object> catalogue;
    int modificationIndex=-1;

    String firstName, lastName, nationality;
    Person.GENDER gender;

    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appUtility=AppUtility.getAppUtility(getApplicationContext());
        initPersonInputForm();
        recyclerView =(RecyclerView) findViewById(R.id.recycleListView);

        people = appUtility.getPeople();
        catalogue=appUtility.getCatalogue();

        listAdapterWithRecycleView=new ListAdapterWithRecycleView(this,catalogue);
        listAdapterWithRecycleView.setPersonModifier(this);

        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapterWithRecycleView);
    }

    private void initPersonInputForm(){
        editTextFirstName = (EditText)findViewById(R.id.editTextFirstName);
        editTextLastName = (EditText)findViewById(R.id.editTextLastName);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroupGender);

        spinnerNationality = (Spinner)findViewById(R.id.spinnerNationality);
        spinnerNationality.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,appUtility.getUniqueNationalitiesArray()));
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setTag("Add");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radioButtonMale: gender = Person.GENDER.MALE; break;
                    case R.id.radioButtonFemale: gender = Person.GENDER.FEMALE; break;
                    default: gender=null;
                }
            }
        });

        spinnerNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                nationality = getResources().getStringArray(R.array.nationalities)[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName = editTextFirstName.getText().toString();
                lastName  = editTextLastName.getText().toString();
                Person person=null;

                if(isInputDataValid()) {
                    person = new Person(firstName, lastName, gender, nationality);
                }else{
                    Toast.makeText(MainActivity.this,"Input Invalid",Toast.LENGTH_LONG).show();
                }

                String behaviour = (String)buttonAdd.getTag();
                if(behaviour.equalsIgnoreCase("Add")){
                    if(person!=null){
                        people.add(person);
                        listAdapterWithRecycleView.notifyDataSetChanged();
                        recyclerView.scrollToPosition(people.size()-1);
                        clearInputForm();
                    }
                }else if(behaviour.equalsIgnoreCase("modify")){
                    if(person!=null){
                        try{
                            people.get(modificationIndex).setName(person.getName());
                            people.get(modificationIndex).setLastname(person.getLastname());
                            people.get(modificationIndex).setGender(person.getGender());
                            people.get(modificationIndex).setNationality((String)spinnerNationality.getSelectedItem());

                            listAdapterWithRecycleView.notifyItemChanged(modificationIndex);
                            clearInputForm();
                            buttonAdd.setTag("Add");
                            buttonAdd.setText("Add");
                        }catch (IndexOutOfBoundsException exception){
                            Toast.makeText(MainActivity.this,"Can't modify, item moved",Toast.LENGTH_LONG ).show();
                            listAdapterWithRecycleView.notifyDataSetChanged();
                            clearInputForm();
                            buttonAdd.setTag("Add");
                            buttonAdd.setText("Add");
                        }
                    }
                }

            }
        });
    }

    private boolean isInputDataValid(){
        if(AppUtility.isStringEmpty(firstName) || AppUtility.isStringEmpty(lastName) || AppUtility.isStringEmpty(nationality) || gender==null){
            return false;
        }else{
            return true;
        }
    }

    private void clearInputForm() {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        radioGroup.clearCheck();
        spinnerNationality.setSelection(0);
    }

    @Override
    public void onPersonSelected(int position) {
        modificationIndex = position;
        Person person=people.get(position);
        buttonAdd.setTag("Modify");
        buttonAdd.setText("Modify");

        editTextFirstName.setText(person.getName());
        editTextLastName.setText(person.getLastname());
        if(person.getGender()== Person.GENDER.MALE){
            ((RadioButton)findViewById(R.id.radioButtonMale)).performClick();
        }else if(person.getGender()== Person.GENDER.FEMALE){
            ((RadioButton)findViewById(R.id.radioButtonFemale)).performClick();
        }
        spinnerNationality.setSelection(appUtility.getNationalityForSelectedIndex(person.getNationality()));
    }

    @Override
    public void onPersonDeleted(int position) {
        buttonAdd.setTag("Add");
        buttonAdd.setText("Add");
        clearInputForm();
    }

}
