package com.drdisagree.iconify.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.drdisagree.iconify.R;
import com.drdisagree.iconify.config.PrefConfig;
import com.drdisagree.iconify.installer.QsShapeInstaller;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class QsShapes extends AppCompatActivity {

    private static final String DEFAULT_KEY = "IconifyComponentQSS1.overlay";
    private static final String DOUBLE_LAYER_KEY = "IconifyComponentQSS2.overlay";
    private static final String SHADED_LAYER_KEY = "IconifyComponentQSS3.overlay";
    private static final String OUTLINE_KEY = "IconifyComponentQSS4.overlay";
    private static final String LEAFY_OUTLINE_KEY = "IconifyComponentQSS5.overlay";
    LinearLayout[] Container;
    LinearLayout DefaultContainer, DoubleLayerContainer, ShadedLayerContainer, OutlineContainer, LeafyOutlineContainer;
    Button Default_Enable, Default_Disable, DoubleLayer_Enable, DoubleLayer_Disable, ShadedLayer_Enable, ShadedLayer_Disable, Outline_Enable, Outline_Disable, LeafyOutline_Enable, LeafyOutline_Disable;
    private ViewGroup container;
    private LinearLayout spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qs_shapes);

        // Header
        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("QS Panel Tiles");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Progressbar while enabling or disabling pack
        spinner = findViewById(R.id.progressBar_QsShape);

        // Don't show progressbar on opening page
        spinner.setVisibility(View.GONE);

        // Qs row column item on click
        LinearLayout qs_row_column = findViewById(R.id.qs_row_column);
        qs_row_column.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QsShapes.this, QsRowColumn.class);
                startActivity(intent);
            }
        });

        // Qs text color item on click
        LinearLayout qs_text_color = findViewById(R.id.qs_text_color);
        qs_text_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QsShapes.this, QsTextColor.class);
                startActivity(intent);
            }
        });

        // Brightness Bar list items
        container = (ViewGroup) findViewById(R.id.qs_tiles_list);

        // Qs Shape add items in list
        addItem(R.id.default_container, R.id.default_qstile1, R.id.default_qstile2, R.id.default_qstile3, R.id.default_qstile4, "Default", R.id.default_enable, R.id.default_disable);
        addItem(R.id.doubleLayer_container, R.id.doubleLayer_qstile1, R.id.doubleLayer_qstile2, R.id.doubleLayer_qstile3, R.id.doubleLayer_qstile4, "Double Layer", R.id.doubleLayer_enable, R.id.doubleLayer_disable);
        addItem(R.id.shadedLayer_container, R.id.shadedLayer_qstile1, R.id.shadedLayer_qstile2, R.id.shadedLayer_qstile3, R.id.shadedLayer_qstile4, "Shaded Layer", R.id.shadedLayer_enable, R.id.shadedLayer_disable);
        addItem(R.id.outline_container, R.id.outline_qstile1, R.id.outline_qstile2, R.id.outline_qstile3, R.id.outline_qstile4, "Outline", R.id.outline_enable, R.id.outline_disable);
        addItem(R.id.leafy_outline_container, R.id.leafy_outline_qstile1, R.id.leafy_outline_qstile2, R.id.leafy_outline_qstile3, R.id.leafy_outline_qstile4, "Leafy Outline", R.id.leafy_outline_enable, R.id.leafy_outline_disable);

        // Default
        DefaultContainer = findViewById(R.id.default_container);
        Default_Enable = findViewById(R.id.default_enable);
        Default_Disable = findViewById(R.id.default_disable);
        LinearLayout Default_QsTile1 = findViewById(R.id.default_qstile1);
        LinearLayout Default_QsTile2 = findViewById(R.id.default_qstile2);
        LinearLayout Default_QsTile3 = findViewById(R.id.default_qstile3);
        LinearLayout Default_QsTile4 = findViewById(R.id.default_qstile4);
        Default_QsTile1.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_default_enabled));
        Default_QsTile2.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_default_disabled));
        Default_QsTile3.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_default_disabled));
        Default_QsTile4.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_default_enabled));

        // Double Layer
        DoubleLayerContainer = findViewById(R.id.doubleLayer_container);
        DoubleLayer_Enable = findViewById(R.id.doubleLayer_enable);
        DoubleLayer_Disable = findViewById(R.id.doubleLayer_disable);
        LinearLayout DoubleLayer_QsTile1 = findViewById(R.id.doubleLayer_qstile1);
        LinearLayout DoubleLayer_QsTile2 = findViewById(R.id.doubleLayer_qstile2);
        LinearLayout DoubleLayer_QsTile3 = findViewById(R.id.doubleLayer_qstile3);
        LinearLayout DoubleLayer_QsTile4 = findViewById(R.id.doubleLayer_qstile4);
        DoubleLayer_QsTile1.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_doublelayer_enabled));
        DoubleLayer_QsTile2.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_doublelayer_disabled));
        DoubleLayer_QsTile3.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_doublelayer_disabled));
        DoubleLayer_QsTile4.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_doublelayer_enabled));

        // Shaded Layer
        ShadedLayerContainer = findViewById(R.id.shadedLayer_container);
        ShadedLayer_Enable = findViewById(R.id.shadedLayer_enable);
        ShadedLayer_Disable = findViewById(R.id.shadedLayer_disable);
        LinearLayout ShadedLayer_QsTile1 = findViewById(R.id.shadedLayer_qstile1);
        LinearLayout ShadedLayer_QsTile2 = findViewById(R.id.shadedLayer_qstile2);
        LinearLayout ShadedLayer_QsTile3 = findViewById(R.id.shadedLayer_qstile3);
        LinearLayout ShadedLayer_QsTile4 = findViewById(R.id.shadedLayer_qstile4);
        ShadedLayer_QsTile1.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_shadedlayer_enabled));
        ShadedLayer_QsTile2.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_shadedlayer_disabled));
        ShadedLayer_QsTile3.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_shadedlayer_disabled));
        ShadedLayer_QsTile4.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_shadedlayer_enabled));

        // Outline
        OutlineContainer = findViewById(R.id.outline_container);
        Outline_Enable = findViewById(R.id.outline_enable);
        Outline_Disable = findViewById(R.id.outline_disable);
        LinearLayout Outline_QsTile1 = findViewById(R.id.outline_qstile1);
        LinearLayout Outline_QsTile2 = findViewById(R.id.outline_qstile2);
        LinearLayout Outline_QsTile3 = findViewById(R.id.outline_qstile3);
        LinearLayout Outline_QsTile4 = findViewById(R.id.outline_qstile4);
        Outline_QsTile1.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_outline_enabled));
        Outline_QsTile2.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_outline_disabled));
        Outline_QsTile3.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_outline_disabled));
        Outline_QsTile4.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_outline_enabled));

        // Leafy Outline
        LeafyOutlineContainer = findViewById(R.id.leafy_outline_container);
        LeafyOutline_Enable = findViewById(R.id.leafy_outline_enable);
        LeafyOutline_Disable = findViewById(R.id.leafy_outline_disable);
        LinearLayout LeafyOutline_QsTile1 = findViewById(R.id.leafy_outline_qstile1);
        LinearLayout LeafyOutline_QsTile2 = findViewById(R.id.leafy_outline_qstile2);
        LinearLayout LeafyOutline_QsTile3 = findViewById(R.id.leafy_outline_qstile3);
        LinearLayout LeafyOutline_QsTile4 = findViewById(R.id.leafy_outline_qstile4);
        LeafyOutline_QsTile1.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_leafy_outline_enabled));
        LeafyOutline_QsTile2.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_leafy_outline_disabled));
        LeafyOutline_QsTile3.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_leafy_outline_disabled));
        LeafyOutline_QsTile4.setBackground(ContextCompat.getDrawable(QsShapes.this, R.drawable.qs_shape_leafy_outline_enabled));

        // List of Brightness Bar
        Container = new LinearLayout[]{DefaultContainer, DoubleLayerContainer, ShadedLayerContainer, OutlineContainer, LeafyOutlineContainer};

        // Enable onClick event
        enableOnClickListener(DefaultContainer, Default_Enable, Default_Disable, DEFAULT_KEY, 1);
        enableOnClickListener(DoubleLayerContainer, DoubleLayer_Enable, DoubleLayer_Disable, DOUBLE_LAYER_KEY, 2);
        enableOnClickListener(ShadedLayerContainer, ShadedLayer_Enable, ShadedLayer_Disable, SHADED_LAYER_KEY, 3);
        enableOnClickListener(OutlineContainer, Outline_Enable, Outline_Disable, OUTLINE_KEY, 4);
        enableOnClickListener(LeafyOutlineContainer, LeafyOutline_Enable, LeafyOutline_Disable, LEAFY_OUTLINE_KEY, 5);

        refreshBackground();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Function to check for layout changes
    private void refreshLayout(LinearLayout layout) {
        for (LinearLayout linearLayout : Container) {
            if (!(linearLayout == layout)) {
                if (linearLayout == DefaultContainer) {
                    Default_Enable.setVisibility(View.GONE);
                    Default_Disable.setVisibility(View.GONE);
                } else if (linearLayout == DoubleLayerContainer) {
                    DoubleLayer_Enable.setVisibility(View.GONE);
                    DoubleLayer_Disable.setVisibility(View.GONE);
                } else if (linearLayout == ShadedLayerContainer) {
                    ShadedLayer_Enable.setVisibility(View.GONE);
                    ShadedLayer_Disable.setVisibility(View.GONE);
                } else if (linearLayout == OutlineContainer) {
                    Outline_Enable.setVisibility(View.GONE);
                    Outline_Disable.setVisibility(View.GONE);
                } else if (linearLayout == LeafyOutlineContainer) {
                    LeafyOutline_Enable.setVisibility(View.GONE);
                    LeafyOutline_Disable.setVisibility(View.GONE);
                }
            }
        }
    }

    // Function to check for bg drawable changes
    private void refreshBackground() {
        checkIfApplied(DefaultContainer, 1);
        checkIfApplied(DoubleLayerContainer, 2);
        checkIfApplied(ShadedLayerContainer, 3);
        checkIfApplied(OutlineContainer, 4);
        checkIfApplied(LeafyOutlineContainer, 5);
    }

    // Function for onClick events
    private void enableOnClickListener(LinearLayout layout, Button enable, Button disable, String key, int index) {

        // Set onClick operation for options in list
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshLayout(layout);
                if (!PrefConfig.loadPrefBool(getApplicationContext(), key)) {
                    disable.setVisibility(View.GONE);
                    if (enable.getVisibility() == View.VISIBLE)
                        enable.setVisibility(View.GONE);
                    else
                        enable.setVisibility(View.VISIBLE);
                } else {
                    enable.setVisibility(View.GONE);
                    if (disable.getVisibility() == View.VISIBLE)
                        disable.setVisibility(View.GONE);
                    else
                        disable.setVisibility(View.VISIBLE);
                }
            }
        });

        // Set onClick operation for Enable button
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshLayout(layout);
                // Show spinner
                spinner.setVisibility(View.VISIBLE);
                // Block touch
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        disable_others(key);
                        QsShapeInstaller.install_pack(index);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                PrefConfig.savePrefBool(getApplicationContext(), key, true);
                // Wait 1 second
                spinner.postDelayed(new Runnable() {
                    public void run() {
                        // Hide spinner
                        spinner.setVisibility(View.GONE);
                        // Unblock touch
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        // Change background to selected
                        background(layout.getId(), R.drawable.container_selected);
                        // Change button visibility
                        enable.setVisibility(View.GONE);
                        disable.setVisibility(View.VISIBLE);
                        refreshBackground();
                        Toast.makeText(getApplicationContext(), "Applied", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        // Set onClick operation for Disable button
        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show spinner
                spinner.setVisibility(View.VISIBLE);
                // Block touch
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        QsShapeInstaller.disable_pack(index);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
                PrefConfig.savePrefBool(getApplicationContext(), key, false);
                // Wait 1 second
                spinner.postDelayed(new Runnable() {
                    public void run() {
                        // Hide spinner
                        spinner.setVisibility(View.GONE);
                        // Unblock touch
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        // Change background to selected
                        background(layout.getId(), R.drawable.container);
                        // Change button visibility
                        disable.setVisibility(View.GONE);
                        enable.setVisibility(View.VISIBLE);
                        refreshBackground();
                        Toast.makeText(getApplicationContext(), "Disabled", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });
    }

    // Function to disable other packs if one is applied
    private void disable_others(String pack) {
        PrefConfig.savePrefBool(getApplicationContext(), DEFAULT_KEY, pack.equals(DEFAULT_KEY));
        PrefConfig.savePrefBool(getApplicationContext(), DOUBLE_LAYER_KEY, pack.equals(DOUBLE_LAYER_KEY));
        PrefConfig.savePrefBool(getApplicationContext(), SHADED_LAYER_KEY, pack.equals(SHADED_LAYER_KEY));
        PrefConfig.savePrefBool(getApplicationContext(), OUTLINE_KEY, pack.equals(OUTLINE_KEY));
        PrefConfig.savePrefBool(getApplicationContext(), LEAFY_OUTLINE_KEY, pack.equals(LEAFY_OUTLINE_KEY));
    }

    // Function to change applied pack's bg
    private void checkIfApplied(LinearLayout layout, int qsshape) {
        if (PrefConfig.loadPrefBool(getApplicationContext(), "IconifyComponentQSS" + qsshape + ".overlay")) {
            background(layout.getId(), R.drawable.container_selected);
        } else {
            background(layout.getId(), R.drawable.container);
        }
    }

    // Function to add border for installed pack
    private void background(int id, int drawable) {
        LinearLayout layout = findViewById(id);
        layout.setBackground(ContextCompat.getDrawable(this, drawable));
    }

    private void addItem(int id, int qstile1id, int qstile2id, int qstile3id, int qstile4id, String title, int enableid, int disableid) {
        View list = LayoutInflater.from(this).inflate(R.layout.list_option_qstile, container, false);

        TextView name = list.findViewById(R.id.list_title_qstile);
        Button enable = list.findViewById(R.id.list_button_enable_qstile);
        Button disable = list.findViewById(R.id.list_button_disable_qstile);
        LinearLayout qstile1 = list.findViewById(R.id.qs_tile1);
        LinearLayout qstile2 = list.findViewById(R.id.qs_tile2);
        LinearLayout qstile3 = list.findViewById(R.id.qs_tile3);
        LinearLayout qstile4 = list.findViewById(R.id.qs_tile4);

        list.setId(id);
        name.setText(title);

        enable.setId(enableid);
        disable.setId(disableid);

        qstile1.setId(qstile1id);
        qstile2.setId(qstile2id);
        qstile3.setId(qstile3id);
        qstile4.setId(qstile4id);

        container.addView(list);
    }
}