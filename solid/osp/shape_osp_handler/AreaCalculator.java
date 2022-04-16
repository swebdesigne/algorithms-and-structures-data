package solid.osp.shape_osp_handler;

public class AreaCalculator {
    public double areaCalc(Shape... shapes) {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.area();
        }
        return area;
    }
}
