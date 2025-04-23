# Query Keywords no Spring Data JPA

No Spring Data JPA, **Query Keywords** são palavras-chave usadas nos nomes dos métodos dos repositórios para gerar consultas automaticamente, sem precisar escrever SQL ou JPQL manualmente.

## Funcionamento

- **Nomenclatura:** Métodos como `findBy`, `getBy`, `countBy` seguidos de atributos da entidade.
- **Consulta derivada:** O Spring interpreta o nome do método e gera a consulta equivalente.

### Exemplos

```java
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByAgeGreaterThan(int age);
    long countByActiveTrue();
}
```

Vantagens
✅ Produtividade: Menos código pra consultas.

✅ Manutenção: Simples de modificar.

✅ Flexibilidade: Permite consultas complexas com múltiplas keywords.

### Teste
Para realizar testes, utilize o Swagger
http://localhost:8080/swagger-ui/index.html
