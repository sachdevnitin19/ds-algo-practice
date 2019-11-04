import com.nitin.utils.MinMaxStack;

class MinMaxStackTester {
    public static void main(String args[]) {
        MinMaxStack mst=new MinMaxStack();

        mst.push(3);
        System.out.println("Min value= "+mst.getMinValue());
        mst.push(2);
        System.out.println("Min value= "+mst.getMinValue());
        System.out.println("Max value= "+mst.getMaxValue());
        mst.push(6);
        System.out.println("Max value= "+mst.getMaxValue());
        mst.push(4);
        mst.push(1);
        System.out.println("Min value= "+mst.getMinValue());
        mst.push(8);
        System.out.println("Max value= "+mst.getMaxValue());

        System.out.println("popped elem= "+mst.pop());
        System.out.println("Max value= "+mst.getMaxValue());

        System.out.println("popped elem= "+mst.pop());
        System.out.println("Min value= "+mst.getMinValue());
        System.out.println("popped elem= "+mst.pop());
        System.out.println("Max value= "+mst.getMaxValue());

        System.out.println("popped elem= "+mst.pop());
        System.out.println("Max value= "+mst.getMaxValue());

    }
}