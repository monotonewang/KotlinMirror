package montotone.com.github.www.test_thread



class MyThread(name: String) : Thread(name) {
    override fun run() {
        super.run()
        for (index in 1..10){
            System.out.println(Thread.currentThread().name+"index="+index)
        }
    }
}
fun main(){
    val thread1 = MyThread("first")
//    thread1.run()
    val thread2 = MyThread("second")

    thread1.start()
    thread1.join()
    thread2.start()
    thread2.join()

}