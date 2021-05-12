def solution(citations):
    # n : 발표한 논문의 수
    n = len(citations)

    # 정렬
    citations.sort()
    # 가능한 최대 h
    maxi = citations[-1]

    h = 0
    bigger, smaller = 0, 0

    # 0 ~ maxi까지 돌면서 이상/이하 인용된 논문의 개수를 구한다
    for i in range(maxi + 1):
        for c in citations:
            if c >= i:
                bigger += 1
            if c <= i:
                smaller += 1

        # 조건에 맞는 h값이 있다면 구한다 (h의 최대를 구하면 됨)
        if bigger >= i and smaller <= i and i > h:
            h = i
        # 다음 h값으로 넘어가기 전 초기화 필수
        bigger, smaller = 0, 0

    return h