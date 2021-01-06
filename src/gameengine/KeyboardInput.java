package gameengine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyboardInput extends KeyAdapter {
    private Map<Character,Boolean> keysPressed = new HashMap<Character,Boolean>();
    private Map<Character,Boolean> keysHeldPressed = new HashMap<Character,Boolean>();
    private static KeyboardInput instance = new KeyboardInput();

    private KeyboardInput(){

    }

    public static KeyboardInput GetInstance() {
        return instance;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        char keyCode = (char)event.getKeyCode();
        keysPressed.put(keyCode, true);
        keysHeldPressed.put(keyCode, true);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        char keyCode = (char)event.getKeyCode();
        keysHeldPressed.put(keyCode, false);
    }

    public void EndGameLoop() {
        keysPressed.clear();
    }

    public boolean IsKeyPressedThisFrame(char keyCode) {
        keyCode = Character.toUpperCase(keyCode);
        return keysPressed.containsKey(keyCode) && keysPressed.get(keyCode);
    }

    public boolean IsKeyHeldPressedThisFrame(char keyCode) {
        keyCode = Character.toUpperCase(keyCode);
        return keysHeldPressed.containsKey(keyCode) && keysHeldPressed.get(keyCode);
    }
}

