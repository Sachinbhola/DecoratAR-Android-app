package com.example.decoratar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

// Part of Previous Build Using Sceneform Library (Now Deprecated)

public class MainActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private static final String sofa_url = "https://github.com/Sachinbhola/App-Templates/blob/master/Resources/sofa_02_4k.glb";
    private ModelRenderable modelRenderable;
    private String Model_URL = "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/SheenChair/glTF/SheenChair.gltf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        ImageButton button1=findViewById(R.id.btn1);
        ImageButton button2=findViewById(R.id.btn2);
        ImageButton button3=findViewById(R.id.btn3);
        ImageButton button4=findViewById(R.id.btn4);
        ImageButton button5=findViewById(R.id.btn5);
        ImageButton button6=findViewById(R.id.btn6);
        ImageButton button7=findViewById(R.id.btn7);
        ImageButton button8=findViewById(R.id.btn8);

        //https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/gaming_chair_xyz_school_homework/scene.gltf

        //velvet
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/GlamVelvetSofa/glTF/GlamVelvetSofa.gltf";
                start_intent(str);
            }
        });

        //sheen
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/SheenChair/glTF/SheenChair.gltf";
                start_intent(str);
            }
        });

        //caab
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/chair/arm_chair__furniture/scene.gltf";
                start_intent(str);
            }
        });

        //victorian sofa
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/victorian_lounge_sofa/scene.gltf";
                start_intent(str);
            }
        });

        //office chair
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/office%20essentials%20and%20cabinets/gaming_chair_1-_black/scene.gltf";
                start_intent(str);
            }
        });

        //sofa6
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofa_6/scene.gltf";
                start_intent(str);
            }
        });

        //red chester
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/the_matrix_red_chesterfield_chair/scene.gltf";
                start_intent(str);
            }
        });

        //old armchair
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="https://raw.githubusercontent.com/Sachinbhola/App-Templates/master/Resources/sofas/sofa_game_ready__2k_pbr/scene.gltf";
                start_intent(str);
            }
        });

        //sceneformModelRenderOffline();
        //sceneformRemoteRender();

    }

    private void start_intent(String str) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", "" +str)
                        .appendQueryParameter("mode", "ar_only")
                        .build();

        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        startActivity(sceneViewerIntent);
    }

    private void offline_loader() {
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ar_scene_view);
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {//Lambda function of Java 8
            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse("model_fight.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable))
                    .exceptionally(throwable -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setMessage(throwable.getMessage())
                                .show();
                        return null;
                    });
        });
    }
    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(anchorNode);
        transformableNode.setRenderable(modelRenderable);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        transformableNode.select();
    }

    private void test_load() {
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ar_scene_view);
        setUpModel();
        setUpPlane();

    }

    private void setUpModel() {
        ModelRenderable.builder()
                .setSource(this,
                        RenderableSource.builder().setSource(
                                this,
                                Uri.parse(Model_URL),
                                RenderableSource.SourceType.GLTF2)
                                .setScale(0.75f)
                                .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                                .build())

                .setRegistryId(Model_URL)
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Log.i("Model","cant load");
                    Toast.makeText(MainActivity.this,"Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
    }

    private void setUpPlane(){
        arFragment.setOnTapArPlaneListener(((hitResult, plane, motionEvent) -> {
            Anchor anchor = hitResult.createAnchor();
            AnchorNode anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            createModel(anchorNode);
        }));
    }

    private void createModel(AnchorNode anchorNode){
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        node.select();
    }
*/
    }
}

