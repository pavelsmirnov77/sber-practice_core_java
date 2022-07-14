package thread;

public class ResourceClass implements Runnable {
    Resource resource;
    ResourceClass(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.area();
    }
}
