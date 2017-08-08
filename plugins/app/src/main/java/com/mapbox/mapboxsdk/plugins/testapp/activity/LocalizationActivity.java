package com.mapbox.mapboxsdk.plugins.testapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.plugins.testapp.R;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocalizationActivity extends AppCompatActivity implements OnMapReadyCallback {

  @BindView(R.id.mapView)
  MapView mapView;

  private LocalizationPlugin localizationPlugin;
  private boolean mapIsLocalized;
  private String ENGLISH_LANGUAGE_CODE = "en";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_localization);
    ButterKnife.bind(this);
    mapIsLocalized = true;
    Toast.makeText(this, R.string.change_language_instruction, Toast.LENGTH_LONG).show();
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(this);
  }

  @Override
  public void onMapReady(MapboxMap mapboxMap) {
    localizationPlugin = new LocalizationPlugin(mapboxMap);
  }

  @OnClick(R.id.localize_fab)
  public void localizeToggleFab() {
    if (mapIsLocalized) {
      localizationPlugin.setMapTextLanguage(ENGLISH_LANGUAGE_CODE);
      Toast.makeText(this, R.string.map_not_localized, Toast.LENGTH_SHORT).show();
      mapIsLocalized = false;
    } else {
      localizationPlugin.setMapTextLanguage(Locale.getDefault().getLanguage());
      Toast.makeText(this, R.string.map_localized, Toast.LENGTH_SHORT).show();
      mapIsLocalized = true;
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_languages, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.english:
        localizationPlugin.setMapTextToEnglish();
        return true;
      case R.id.spanish:
        localizationPlugin.setMapTextToSpanish();
        return true;
      case R.id.french:
        localizationPlugin.setMapTextToFrench();
        return true;
      case R.id.german:
        localizationPlugin.setMapTextToGerman();
        return true;
      case R.id.russian:
        localizationPlugin.setMapTextToRussian();
        return true;
      case R.id.traditional_chinese:
        localizationPlugin.setMapTextToTraditionalChinese();
        return true;
      case R.id.simplified_chinese:
        localizationPlugin.setMapTextToSimplifiedChinese();
        return true;
      case R.id.portuguese:
        localizationPlugin.setMapTextToPortuguese();
        return true;
      case R.id.arabic:
        localizationPlugin.setMapTextToArabic();
        return true;
      case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
