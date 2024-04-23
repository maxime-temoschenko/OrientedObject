public class Counter {
        private int value = 0;
        public  synchronized void increment(){
            ++value;
        }
        public  synchronized int getValue(){
            return value;
        }
}
