package com.mygdx.game.GameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GameModels.DungeonModel;
import com.mygdx.game.Tools.GameStateManager;
import com.mygdx.game.Tools.State;

import static com.mygdx.game.MyGdxGame.PPM;
import static com.mygdx.game.MyGdxGame.V_HEIGHT;
import static com.mygdx.game.MyGdxGame.V_WIDTH;

/**
 * Created by Clifford Hill on 1/24/2017.
 */



public class DungeonScreen extends State{

    private int width;
    private int height;

    private World world;
    private Box2DDebugRenderer b2dr;

    private OrthographicCamera cam;
    private Viewport gamePort;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;


    private DungeonModel model;

    public DungeonScreen(GameStateManager gsm){
        super(gsm);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //set up box2d stuff
        world = new World(new Vector2(0,0), true); // World ->(Vect2 (forces), BOOL don't calculate bodies at rest)
        b2dr = new Box2DDebugRenderer();
        model = new DungeonModel(world);


        //load the tile map
        map = new TmxMapLoader().load("testmap.tmx");
        renderer = new OrthogonalTiledMapRenderer(map,1); //note here is what changes the tile map size

        //set up the camera
        cam = new OrthographicCamera();
        cam.setToOrtho(false, width, height);
        gamePort = new FitViewport(V_WIDTH / PPM, V_HEIGHT / PPM, cam);
        cam.position.set(gamePort.getWorldWidth() / 2/PPM, gamePort.getWorldHeight() / 2/PPM, 0);
//        cam.zoom *= .05;
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        world.step(1/60f,6,2); //6,2 are recommended
        model.update(dt);
        cam.position.x = model.getHero().getPosX();
        cam.position.y = model.getHero().getPosY();
        cam.update();
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z)){
            cam.zoom *=.5;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.X)){
            cam.zoom /=.5;
        }
    }

    @Override
    public void render(SpriteBatch batch) {


        //box2d stuff
        renderer.setView(cam);
        renderer.render();
        b2dr.render(world, cam.combined);

        //make it so the camera projection is...? it works
        batch.setProjectionMatrix(cam.combined);

//        render sprites here
        batch.begin();
        model.getHero().render(batch);
        batch.end();
    }

    public void resize(int width, int height){
        gamePort.update(width,height);
    }
    @Override
    public void dispose() {

    }
}
