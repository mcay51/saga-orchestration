# saga-orchestration
# Mikroservis Orchestration Projesi

Bu proje, **Orchestration** yöntemiyle **Saga Pattern** kullanarak mikroservisler arasında bir iş akışı yönetir ve **PostgreSQL** veritabanını kullanır. Her mikroservis, işlevsel özellikleri sağlar ve **RabbitMQ** ile haberleşir. **Docker** ve **Docker Compose** kullanarak mikroservisleri ve PostgreSQL veritabanını kapsayıcılarla yönetebilirsiniz.

## Uygulamanın Çalışma Süreci

1. **Order Service** bir sipariş oluşturur ve Saga'yı başlatır.
2. **Inventory Service** stok kontrolü yapar.
3. **Payment Service** ödeme işlemini gerçekleştirir.
4. **Shipping Service** teslimat işlemini yapar.
5. Hata durumunda, **Orchestrator** geri alma işlemlerini başlatır.

## Proje Yapısı

Bu yapı, mikroservisler arasındaki iş akışlarını merkezi bir yönetici aracılığıyla koordine eder ve her bir adımın başarılı olup olmadığını kontrol eder.

## Başlangıç

1. **Docker** ve **Docker Compose** kullanarak proje ortamını başlatmak için:

    ```bash
    docker-compose up
    ```

2. Mikroservislerin her biri belirli bir işlevi yerine getirir ve RabbitMQ ile iletişim kurar. PostgreSQL veritabanı, mikroservislerin veri depolama ihtiyaçlarını karşılar.

## Kullanılan Teknolojiler

- **Orchestration** ve **Saga Pattern**
- **PostgreSQL**
- **RabbitMQ**
- **Docker**
- **Docker Compose**

## Lisans

Bu proje [MIT Lisansı](LICENSE) altında lisanslanmıştır.

## İletişim

Proje hakkında daha fazla bilgi almak veya katkıda bulunmak için iletişime geçebilirsiniz.

