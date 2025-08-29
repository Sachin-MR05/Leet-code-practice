import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    max_salaries = employee.groupby('departmentId')['salary'].transform('max')
    c_groupby = employee[employee['salary'] == max_salaries]
    c_combained =pd.merge(c_groupby,department,left_on="departmentId" ,right_on ="id",how ="left")
    c_combained.rename(columns={"name_y":"Department"},inplace =True)
    c_combained.rename(columns={"name_x":"Employee"},inplace =True)
    c_combained.rename(columns={"salary":"Salary"},inplace =True)

    return c_combained[["Department","Employee","Salary"]]
    