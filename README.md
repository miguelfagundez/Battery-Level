# Battery-Level
Checking battery level in Android using a Broadcast Receiver

## Create a Layout file (activity_main.xml): 

```
    ...
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="120dp"
        android:layout_height="360dp"
        .../>

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:text="Checking battery levels.."
        android:textAppearance="@style/TextAppearance.AppCompat.Large"
        .../>
     ...
```

## MainActivity.java

Define views, a broacast receiver and listeners (checking code for details).

```
    // Views
    private ImageView imageView;
    private TextView textView;
    private Button button;
    
    // Receiver
    private BroadcastReceiver broadcastBatteryLevels;
    
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       setupViews();              // Init views
       setupBroadcastReceiver();  // Init Broadcast Receiver
   }
   
   ...
   
   broadcastBatteryLevels = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                ...
                ...
                //-------------------------------------
                // Do something with this data :)
                //-------------------------------------
                ...
                ...
            }
        };
```

Finally, I need to register the broadcast receiver..

```
  // Set an intent filter for battery changed
  // I need to register my receiver
  IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
  registerReceiver(broadcastBatteryLevels, intentFilter);
```


## Final result:
<p align = "center">
<img src="/images/01.png" width="200"> <img src="/images/02.png" width="200"> <img src="/images/03.png" width="200"> <img src="/images/04.png" width="200">
</p>

