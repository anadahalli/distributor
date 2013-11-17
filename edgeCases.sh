#!/usr/bin/sh

# working case
java WorkDistributor 31 5 5
echo -e "\n"

# string in argument
java WorkDistributor sdf 5 5
echo -e "\n"

# argument 0
java WorkDistributor 32 0 5
echo -e "\n"

# 1 argument
java WorkDistributor 1 1 1
echo -e "\n"

# 1 argument
java WorkDistributor 1 1 
echo -e "\n"
