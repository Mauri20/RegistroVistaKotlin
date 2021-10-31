package com.claseoct.ejerciciooct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView




class MainActivity : AppCompatActivity() {
    //Creamos las variables que manejaran los objetos de la vista
    private lateinit var etName:EditText
    private lateinit var etLastName:EditText
    private lateinit var espDepto:Spinner
    private lateinit var espMuni:Spinner
    private lateinit var rgGender:RadioGroup
    private lateinit var rbMale:RadioButton
    private lateinit var rbFemale:RadioButton
    private lateinit var etPhone:EditText
    private lateinit var btSave:Button
    private lateinit var tvRes:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se asignan los objetos de la vista a las variables anteriores
        etName = findViewById(R.id.txtName)
        etLastName = findViewById(R.id.txtLastName)
        espDepto = findViewById(R.id.spin_Depto)
        espMuni = findViewById(R.id.spin_Muni)
        rgGender = findViewById(R.id.rgGender)
        rbMale = findViewById(R.id.radioMale)
        rbFemale = findViewById(R.id.radioFemale)
        etPhone = findViewById(R.id.txtPhone)
        btSave = findViewById(R.id.btnSave)
        tvRes = findViewById(R.id.tvResults)

        //Lenando el spinner de Departamentos
        val opciones = arrayOf(
            "San Salvador",
            "Chalatenango",
            "Sonsonate",
            "La Paz",
            "La Libertad",
            "San Miguel",
            "Usulután",
            "Cabañas",
            "Santa Ana",
            "San Vicente",
            "La Unión",
            "Morazán",
            "Cuscatlán",
            "Ahuachapán"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        espDepto.adapter = adaptador

        //Funcion para recoger un listado de municipios de acuerdo a un departamento
        fun getMunicipios(depto:String):ArrayList<String>{
            val muni= arrayListOf<String>()
            when(depto){
                "Chalatenango"->muni.addAll(listOf("Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                        "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                        "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                        "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                        "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->muni.addAll(listOf("Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                        "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                        "Soyapango","Tonacatepeque"))
                "Sonsonate"->muni.addAll(listOf("Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                        "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                        "Sonzacate"))
                "La Paz"->muni.addAll(listOf("Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                        "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                        "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                        "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->muni.addAll(listOf("Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                        "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                        "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->muni.addAll(listOf("Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                        "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                        "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->muni.addAll(listOf("Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                        "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                        "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->muni.addAll(listOf("Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                        "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->muni.addAll(listOf("Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                        "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->muni.addAll(listOf("Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                        "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->muni.addAll(listOf("Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                        "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->muni.addAll(listOf("Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                        "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                        "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->muni.addAll(listOf("Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                        "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                        "Suchitoto","Tenancingo"))
                "Ahuachapán"->muni.addAll(listOf("Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                        "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }
            return muni
        }

        //Esta parte simula el evento ItemChange de una lista
        espDepto?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Codigo para cargar el otro spinner
                var depart:String=espDepto.selectedItem.toString()
                val adaptadorMuni = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, getMunicipios(depart))
                espMuni.adapter=adaptadorMuni
            }
        }

        //Recogiendo los valores de la vista y guardandolos en un arrayList
        var information= arrayListOf<Array<String>>()
        btSave.setOnClickListener(View.OnClickListener {
            var nombre=etName.text.toString()
            var apellido=etLastName.text.toString()
            var dept=espDepto.selectedItem.toString()
            var munic=espMuni.selectedItem.toString()
            var genero=""
            if(rbMale.isChecked){
                genero="Masculino"
            }else if(rbFemale.isChecked){
                genero="Femenino"
            }
            var telef=etPhone.text.toString()

            information.addAll(listOf(arrayOf(nombre,apellido,dept,munic,genero,telef)))
            tvRes.setText("")
            for(i in 0..information.size-1){
                tvRes.append("Nombre: "+information[i].get(0).toString()+" "+information[i].get(1).toString()+
                        " Departamento: "+information[i].get(2).toString()+" Municipio: "+information[i].get(3).toString()+
                        " Género: "+information[i].get(4).toString()+" Teléfono: "+information[i].get(5).toString()+System.getProperty("line.separator")+
                        "---------------------------------"+System.getProperty("line.separator"))
            }
            Toast.makeText(this,"Registro exitoso ", Toast.LENGTH_LONG).show()
            //Limpiando los campos
            etName.setText("")
            etLastName.setText("")
            espDepto.setSelection(0)
            espMuni.setSelection(0)
            rbMale.isSelected=true
            etPhone.setText("")
        })
    }
}