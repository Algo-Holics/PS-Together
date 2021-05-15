import math


def solution(progresses, speeds):

    # 기능들의 개수
    n = len(progresses)
    # 남은 양
    left = [100 - p for p in progresses]
    # 남은 시간 : 남은 양 / 시간 <<== 이걸 올림처리 해준다 (2.5일 걸린다 == 3일 걸린다)
    to_finish = [math.ceil(left[i] / speeds[i]) for i in range(n)]

    # 며칠 걸리는지
    stack = [to_finish[0]]
    # 개수는 1부터 시작 (0번 넣은 채로 시작)
    answer = [1]
    for i in range(1, n):
        # 만약 이번 기능에 남은 시간이 기존 배포에 걸리는 시간보다 적으면 같이 배포 가능
        if to_finish[i] <= stack[-1]:
            answer[-1] += 1
        # 아니라면 새로운 날에 배포
        else:
            answer.append(1)
            stack.append(to_finish[i])
    # print(answer)
    return answer


# solution([93, 30, 55], [1, 30, 5])
# solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1])
solution([96, 99, 98, 97], [1, 1, 1, 1])