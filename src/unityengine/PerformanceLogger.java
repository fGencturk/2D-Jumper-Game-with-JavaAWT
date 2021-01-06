package unityengine;

public class PerformanceLogger extends MonoBehavior {
    private long lastExecutionTime;
    private int frameCount;
    @Override
    public void Awake() {
        System.out.println("Game engine is awaking.");
        lastExecutionTime = System.currentTimeMillis();
    }

    @Override
    public void Start() {
        System.out.println("Game main loop is starting. (Took : " + (System.currentTimeMillis() - lastExecutionTime) + " miliseconds)");
        lastExecutionTime = System.currentTimeMillis();
        frameCount = 0;
    }

    @Override
    public void Update() {
        frameCount++;
        if(GetSecondsDifference() >= 1) {
            System.out.println("Number of frames drawn in the last second : " + frameCount);
            frameCount = 0;
            lastExecutionTime = System.currentTimeMillis();
        }
    }

    private long GetSecondsDifference(){
        return (System.currentTimeMillis() - lastExecutionTime) / 1000;
    }
}
