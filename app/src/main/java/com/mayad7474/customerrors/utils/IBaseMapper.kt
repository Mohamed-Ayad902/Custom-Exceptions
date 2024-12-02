package com.mayad7474.customerrors.utils

interface IBaseMapper<Dto, Domain> {
    fun mapToDomain(dto: Dto): Domain
    fun mapToDto(domain: Domain): Dto
}