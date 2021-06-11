if __name__ == '__main__':
   students_grade = []
   for _ in range(int(input())):
        name = input()
        score = float(input())
        students_grade.append([name,score])
   sorted_scores = sorted(list(set[x[1]]))
   for x in students_grade:
   	second_lowest=sorted_scores[1]
   	low_final_list=[]
   for student in students_grade:
        if second_lowest==student[1]:
            low_final_list.append(student[0])
   for student in sorted(low_final_list):
        print(student)