package gameengine;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }

    public static Vector2 Sum(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public static Vector2 GetVector2WithMagnitude(Vector2 a, float magnitude) {
        float m = (float)Math.sqrt(a.x * a.x + a.y * a.y);
        return new Vector2(a.x / m * magnitude, a.y / m * magnitude);
    }
}
