def solution(array, commands):
    answer = []

    # 각 command에 대해서 k번째 찾기
    for command in commands:
        # 시작, 끝, k번째 인덱스의 값들을 각 변수에 넣어줌
        start, end, idx = command
        # 시작-1 (0번째가 아닌 1번째부터 시작하니까), end는 그대로 (마지막 인덱스는 포함하지 않음)
        tmp = sorted(array[start - 1:end])
        # k-1번째를 answer 리스트에 넣어준다
        answer.append(tmp[idx - 1])

    return answer
