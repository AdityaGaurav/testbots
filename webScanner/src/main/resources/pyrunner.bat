set HERE=%CD%
cd /d "E:\infinity\gitrepo\testbots\decisionTree\src"
start icacls "E:\infinity\gitrepo\testbots\decisionTree\src" /grant adityag:(OI)(CI)F /T & python main.py  & python program.py