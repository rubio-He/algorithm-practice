#
# @lc app=leetcode id=1115 lang=python3
#
# [1115] Print FooBar Alternately
#
import threading
# @lc code=start
class FooBar:
    def __init__(self, n):
        self.n = n
        self.n = n
        self.l1=threading.Lock()
        self.l1.acquire()
        self.l2=threading.Lock()


    def foo(self, printFoo: 'Callable[[], None]') -> None:
        
        for i in range(self.n):
            self.l2.acquire()
            # printFoo() outputs "foo". Do not change or remove this line.
            printFoo()
            self.l1.release()


    def bar(self, printBar: 'Callable[[], None]') -> None:
        
        for i in range(self.n):
            self.l1.acquire() 
            # printBar() outputs "bar". Do not change or remove this line.
            printBar()
            self.l2.release()
# @lc code=end

