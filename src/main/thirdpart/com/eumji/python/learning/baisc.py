print("hello world")

names = ["zhangsan", "lis", "wangwu"]
print(names)
print("print the first =", names[0])
print("print the last =", names[-1])
print("print the[0-1] =", names[:2])
print("print the[2-last] = ", names[2:])

names.append("mazi")
print(names)
names.remove("lisi")
print(names)
del names
# can't print ,it will no exit
# print(names)


# tuple means can't change value,append,delete
names2 = ("zhangsan", "lis", "wangwu")
print(names2)
print(type(names2))
print("print the first =", names2[0])
print("print the last =", names2[-1])
print("print the[0-1] =", names2[:2])
print("print the[2-last] = ", names2[2:])

#不能新增删除