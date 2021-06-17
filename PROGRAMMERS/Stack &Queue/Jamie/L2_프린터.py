from collections import deque


def solution(priorities, location):
    # 대기목록의 중요도와 인덱스를 튜플로 같이 저장한다
    order = deque([(n, idx) for idx, n in enumerate(priorities)])

    q = []  # q = 최종 인쇄 순서
    while len(order) != 1:  # 마지막 한개만 남을 때까지
        # 만약 현재 중요도보다 더 큰 중요도가 있으면 뒤로 넘기고, 아니면 q에 추가
        now = order.popleft()
        priority, idx = now
        maxi = max(order)[0]
        if maxi > priority:
            order.append(now)
        else:
            q.append(now)
    # 마지막 남은 한개도 q에 추가
    q.append(order.popleft())

    # 기존 location과 일치하는 인덱스를 찾으면 해당 인덱스 리턴
    for i in range(len(q)):
        p, idx = q[i]
        if idx == location:
            print(i+1)
            return i+1


solution([2, 1, 3, 2], 2)
solution([1, 1, 9, 1, 1, 1], 0)