CREATE TABLE translations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    locale VARCHAR(5),
    m_key VARCHAR(255),
    m_value TEXT
);
