package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private Integer cradioSexGroup;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button bnRegistration, bnlogin;
        EditText tname, tnationalid, tusername, taccountNumber, tgender, temail, tphonenumber, taddress, tpin, tcmpin;
        private Integer cradioSexGroup;
        private RadioGroup radioSexGroup;
        private RadioButton radioSexButton;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);


            tname = findViewById(R.id.customerName);
            tusername = findViewById(R.id.username);
            taccountNumber = findViewById(R.id.accountNumber);

            temail = findViewById(R.id.email);
            // set the curret state of a radio button
//        radioSexGroup = findViewById(R.id.radioSex);
//        int radioButtonID =        radioSexGroup .getCheckedRadioButtonId();
//        radioSexButton = radioSexGroup .findViewById(radioButtonID);
//        tgender = findViewById(R.id.g);
//        tnationalid = findViewById(R.id.nationalId);
//        tphonenumber = findViewById(R.id.phoneNumber);
//        taddress = findViewById(R.id.address);
//        radioSexGroup = findViewById(R.id.radioSex);
//        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int selectedId = radioSexGroup.getCheckedRadioButtonId();
//                radioSexButton = findViewById(selectedId);
//                Toast.makeText(Registration.this, radioSexButton.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
            tpin = findViewById(R.id.pin);
            tcmpin = findViewById(R.id.confirm_pin);
            bnRegistration = findViewById(R.id.btnRegistration);
            bnlogin = findViewById(R.id.btnLogin);

            bnRegistration.setOnClickListener(new View . OnClickListener () {
                @Override
                public void onClick(View v) {
                    callRegister();

                }
            });

            bnRegistration.setOnClickListener(new View . OnClickListener (){

                @Override
                public void onClick(View v) {
                    callRegister();
                }
            });
            bnlogin.setOnClickListener(new View . OnClickListener (){

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Registration.this, Login.class);
                    startActivity(intent);
                }
            });
        }

        public void callRegister() {
            String sname = tname . getText ().toString().trim();

            String sAccountNumber = taccountNumber . getText ().toString().trim();
            String susername = tusername . getText ().toString().trim();

            String semail = temail . getText ().toString().trim();
//        String snationalId=tnationalid.getText().toString().trim();
//        String sgender = (String) radioSexButton.getText();
//        Integer sphoneNumber=Integer.parseInt(tphonenumber.getText().toString());
//        String sAddress=  taddress .getText().toString().trim();
            Integer sConfirmPin = Integer . parseInt (tcmpin.getText().toString().trim());
            Integer sPin = Integer . parseInt (tpin.getText().toString().trim());
            // Call<UserInfo> call= ApiClient.getInstance().getApi().callRegister(sname,snationalId,sAccountNumber,susername,sgender,semail,sphoneNumber,sAddress,sPin,sConfirmPin);
            Call<UserInfo> call = ApiClient . getInstance ().getApi().callRegister(
                sname,
                sAccountNumber,
                susername,
                semail,
                sPin,
                sConfirmPin
            );
            call.enqueue(new Callback < UserInfo >() {
                @Override
                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                    UserInfo userInfo = response . body ();
                    if (userInfo != null) {
                        Toast.makeText(
                            Registration.this,
                            "Success Registration ",
                            Toast.LENGTH_SHORT
                        ).show();

                    } else {
                        Toast.makeText(Registration.this, " failed", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<UserInfo> call, Throwable t) {

                }
            });
        }
        //   bnreg = findViewById(R.id.btnRegistration);
//        bnreg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // formValidation();
//                JsonObject jsonObject = new JsonObject();
//                customername = cname.getText().toString();
//                nationaid = cnationalid.getText().toString();
//                userName = cusername.getText().toString();
//                emailc = cemail.getText().toString();
//                gender = radioSexButton.getText().toString();
//                phone_numberc = cphonenumber.getText().toString();
//                addressc = caddress.getText().toString();
//                pinc = cpin.getText().toString();
//                cmpinc = cmpin.getText().toString();
//                //add values/data to json object
//                jsonObject.addProperty("customer_name", customername);
//                jsonObject.addProperty("national_id", nationaid);
//                jsonObject.addProperty("username", userName);
//                jsonObject.addProperty("gender", gender);
//                jsonObject.addProperty("email", emailc);
//                jsonObject.addProperty("address", addressc);
//                jsonObject.addProperty("phone_number", phone_numberc);
//                jsonObject.addProperty("pin", pinc);
//                jsonObject.addProperty("confirm_pin", cmpinc);
//                registerUser(jsonObject);
//            }
//        });

        //}

//    public void registerUser(JsonObject jsonObject) {
//        //call our interface class which contains our endpoint
//        ApiInterface Interface = ApiClient.getClient().create(ApiInterface.class);
//        Call<JsonObject> callRegistration = Interface.callRegister(jsonObject);
//        //enqueue() asynchronously sends the request and notifies your app with a callback when a response comes back
//        callRegistration.enqueue(new retrofit2.Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
//                if (response.body() != null) {
//                    Toast.makeText(Registration.this, "res" + response.body(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(Registration.this, "Registration successfully", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Registration.this, Login.class);
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Toast.makeText(Registration.this, "res" + t.getMessage(), Toast.LENGTH_LONG).show();
//                // Toast.makeText(Registration.this, "failed", Toast.LENGTH_SHORT).show();
//                Log.e("onFailure", "" + t.toString());
//            }
//        });
//    }

        //form validation
//    public void formValidation() {
//
//        if (userName.isEmpty()) {
//            Toast.makeText(this, "please enter your username", Toast.LENGTH_SHORT).show();
//        }
//
//
//    }
    }